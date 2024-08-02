select
    a.menu_code
  , a.menu_name
  , a.category_code
  , b.category_name
from
    tbl_menu a
join
    tbl_category b
on
    a.category_code = b.category_code;
# on a.category_code > b.category_code; # 비등가 조인 : between같은 어떤 값 사이에 join을 할 경우 사용

# on을 사용하는 경우가 더 많다.
select
    menu_code
  , menu_name
  , category_code
  , category_name
from
    tbl_menu
join
    tbl_category
using (category_code);

select
    a.category_name
  , b.menu_name
# from tbl_category a left join tbl_menu b 이렇게 봤을때 left(왼쪽) null 값도 포함시켜서 조회
from
    tbl_category a
left join
    tbl_menu b
on
    a.category_code = b.category_code;

select
    a.menu_name
  , b.category_name
from
    tbl_menu a
right join #부족한 쪽 행을 추가해서 null로 채움 (사용빈도 낮음)
    tbl_category b
on
    a.category_code = b.category_code;

# cross join = 카테이션 곱
