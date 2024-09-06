from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough
from fastapi import FastAPI, Form
from typing import Annotated

load_dotenv(dotenv_path="../99_env/.env")

embedding_model = OpenAIEmbeddings()

vectorstore = FAISS.load_local(
    "./db/faiss",
    embedding_model,
    allow_dangerous_deserialization=True
)

retriever = vectorstore.as_retriever(
    search_type="similarity",
    search_kwars={"k": 5}
)

message=""" 
Answer this question using the provided context only.

{question}

Context:
{context}
"""

prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "주택 임대차 보호법에 대하여 일반인이 자세하고 이해하기 쉽게 설명해주세요"),
        ("human", message)
    ]
)

model = ChatOllama(
    model = "gemma2:2b",
    temperature=0.3
)

chain = {"context": retriever, "question": RunnablePassthrough()} | prompt | model

app = FastAPI()

@app.post("/rag-test", tags=["전세"])
async def rag_practice(question: Annotated[str, Form()]):
    return {"answer": chain.invoke(question).content}









