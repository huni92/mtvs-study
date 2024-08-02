select
    distinct category_code
from
    tbl_menu
order by
    category_code;

select
    distinct ref_category_code
from
    tbl_category;

# distinct 는 select에서 하나만 사용가능 묶어서 중복체크함 4 Y 랑 4 N 도 Y랑 N이 다르기 때문에 나옴
select
      distinct category_code
    , orderable_status
from tbl_menu;
