insert into tbl_menu

# null = auto increment 때문에 증가한다고 생각하면 됨 (찾아볼내용) primary key여야함
values (null, '바나나해장국', 8500, 4, 'Y');

select * from tbl_menu;

insert
  into tbl_menu
(
 menu_name, menu_price, category_code
, orderable_status
)
values
(
 '초콜릿죽', 6500, 7
, 'Y'
);

select * from tbl_menu;

insert into tbl_menu (orderable_status, menu_price, menu_name, category_code)
values ('Y', 5500, '파인애플탕', 4);

select * from tbl_menu;

insert into tbl_menu
values
    (null, '참치맛아이스크림', 1700, 12, 'Y'),
    (null, '멸치맛아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛커피', 2500, 8, 'Y');

select * from tbl_menu;

select
    menu_code
  , category_code
from
    tbl_menu
where
    menu_name = '파인애플탕';

update
    tbl_menu
set
    category_code = 7
where
    menu_code = 25;

# mysql에서는 서브쿼리안에서 다루는 테이블이 메인쿼리에서 다루는 테이블과 동일 테이블일시 오류발생
update
    tbl_menu
set
    category_code = 6
where menu_code = (select
                       menu_code
                   from
                       tbl_menu
                   where
                        menu_name = '파인애플탕'
                   );

update
    tbl_menu
set
    category_code = 6
where
    menu_code = (select tmp.menu_code
                 from (select menu_code
                       from tbl_menu
                       where menu_name = '파인애플탕'
                       ) tmp
                 );

delete from tbl_menu
where menu_code = 25;

select * from tbl_menu;

desc tbl_menu;

SELECT ASCII('A'), CHAR(65);

SELECT BIT_LENGTH('pie'), CHAR_LENGTH('pie'), LENGTH('pie');
SELECT menu_name, BIT_LENGTH(menu_name), CHAR_LENGTH(menu_name), LENGTH(menu_name) from tbl_menu;

SELECT CONCAT('호랑이', '기린', '토끼');
SELECT CONCAT_WS(',', '호랑이', '기린', '토끼');
SELECT CONCAT_WS('-', '2023', '05', '31');

SELECT
    ELT(2, '사과', '딸기', '바나나'), FIELD('딸기', '사과', '딸기', '바나나'),
    FIND_IN_SET('바나나', '사과,딸기,바나나'), INSTR('사과딸기바나나', '딸기'), LOCATE('딸기', '사과딸기바나나');

SELECT FORMAT(123142512521.5635326, 3);

SELECT BIN(65), OCT(65), HEX(65);

SELECT INSERT('내 이름은 아무개입니다.', 7, 3, '홍길동');

SELECT LEFT('Hello World!', 3), RIGHT('Hello World!', 3);

SELECT LOWER('Hello World!'), UPPER('Hello World!');

SELECT LPAD('왼쪽', 6, '@'), RPAD('오른쪽', 6 ,'@');

SELECT LTRIM('    왼쪽'), RTRIM('오른쪽    ');

SELECT TRIM('    MySQL    '), TRIM(BOTH '@' FROM '@@@@MySQL@@@@');

SELECT REPEAT('재밌어', 3);

SELECT REPLACE('마이SQL', '마이', 'My');

SELECT REVERSE('stressed');

SELECT CONCAT('제 이름은', SPACE(5), '이고 나이는', SPACE(3), '세입니다.');

SELECT SUBSTRING('안녕하세요 반갑습니다.', 7, 2), SUBSTRING('안녕하세요 반갑습니다.', 7);

SELECT SUBSTRING_INDEX('hong.test@gmail.com', '.', 2), SUBSTRING_INDEX('hong.test@gmail.com', '.', -2);

SELECT ABS(-123);

SELECT CEILING(1234.56), FLOOR(1234.56), ROUND(1234.56);

SELECT CONV('A', 16, 10), CONV('A', 16, 2), CONV(1010, 2, 8);

SELECT MOD(75, 10), 75 % 10, 75 MOD 10;

SELECT POW(2, 4), SQRT(16);

SELECT RAND(), FLOOR(RAND() * (11 - 1) + 1);

SELECT SIGN(10.1), SIGN(0), SIGN(-10.1);

SELECT TRUNCATE(12345.12345, 2), TRUNCATE(12345.12345, -2);

SELECT ADDDATE('2023-05-31', INTERVAL 30 DAY), ADDDATE('2023-05-31', INTERVAL 6 MONTH);

SELECT ADDTIME('2023-05-31 09:00:00', '1:0:1'), SUBTIME('2023-05-31 09:00:00', '1:0:1');

SELECT CURDATE(), CURTIME(), NOW(), SYSDATE();

-- CURDATE(), CURRENT_DATE(), CURRENT_DATE는 동일
SELECT CURDATE(), CURRENT_DATE(), CURRENT_DATE;

-- CURTIME(), CURRENT_TIME(), CURRENT_TIME은 동일
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIME;

-- NOW(), LOCALTIME, LOCALTIME(), LOCALTIMESTAMP, LOCALTIMESTAMP()는 동일
SELECT NOW(), LOCALTIME, LOCALTIME(), LOCALTIMESTAMP, LOCALTIMESTAMP();

SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAYOFMONTH(CURDATE());
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURRENT_TIME), MICROSECOND(CURRENT_TIME);

SELECT DATE(NOW()), TIME(NOW());

SELECT DATEDIFF('2023-05-31', NOW()), TIMEDIFF('17:07:11', '13:06:10');