package DAO;

import java.sql.SQLException;
import java.util.List;

public class Query {

	// info and parson UP << 인설트 2    
	
	// user id + carid + 날자선택 (car id date 확인해서 안되는날 date false <<- select)  
	

	// user 선택한 자동차  출력
	
	// 예약 번호로 예약 조회하는 쿼리
	String reservation = " SELECT ri.name as 예약자, cm.carname as 차량명, ci.cartype as 차종, ci.brand as 차량브랜드, "
			+ "ci.puel as 유종, rp.Phone_num as 예약자전화번호, re.rent_date as 렌트일, re.return_date as 반납일, "
			+ "(day(re.rent_date - re.return_date)*ci.priceperday) as 가격, ri.pay as 결제여부 "
			+ "from reservation_info as ri "
			+ "join reservation_person_info as rp on ri.name = rp.name "
			+ "join recruittable as re on re.id = ri.id "
			+ "join carmanagement as cm on cm.carid = re.carid "
			+ "join carinfo as ci on ci.carname = cm.carname "
			+ "where ri.id = ? ";
	
	
	
	// 추가 x
	String CAR_UPDATE = " insert into carmanagement(carname, carnum, isborrow) values( ?, ?, ?) ";
	
	// 수정 x
	String CAR_PRICE_SET = " update carinfo set priceperday = ? where carname = ? ";
	
	// 삭제 x
	
	
	// 전체 조회
	String ALL_VIEW = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname ";

	// 필터조회
	
	// 대여가능 ㄱ 
	String IS_BORROW = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where cm.isborrow = 1  ";
	
	// 차량종별
	// 준중형
	String BRAND_COMPACT = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.brand = '준중형' ; ";
	// 중형
	String BRAND_MEDIUM = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.brand = '중형'  ";
	// 대형
	String BRAND_LARGE = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.brand = '대형형' ; ";
	
	
	// 브랜드별
	// 기아
	String CARTYPE_KIA = "select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.cartype = '기아' ";
	// 현대
	String CARTYPE_HYUNDAI = "select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.cartype = '현대' ";
	// 테슬라
	String CARTYPE_TESLA = "select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname where ci.cartype = '테슬라' ";
	
	// 연료별
	
	String SELEC_PUEL = " select cm.carname as 차량명, ci.cartype as 차종, ci.brand as 차량브랜드, "
			+ "ci.puel as 유종, ci.needlicence as 요구면허, ci.priceperday as 1일당가격 "
			+ "from carmanagement as cm "
			+ "join carinfo as ci on cm.carname = ci.carname"
			+ "where ci.puel = ? ";
	
	// 가솔린
	String GASOLINE = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname  where ci.puel = '가솔린' ; ";
	// 전기
	String ELECTRIC = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname  where ci.puel = '전기' ; ";
	// 수소
	String HYDROGEN = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname  where ci.puel = '수소' ; ";
	// 가스
	String GAS = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname  where ci.puel = '가스' ; ";
	// 디젤
	String DIESEL = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname  where ci.puel = '가솔린' ; ";
	
	
	// 가격 범위별
	// 정렬?
	// 가격이 높은순 
	String MAX_PRICE = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname order by ci.priceperday dese ";
	
	// 가격이 낮은순 
	String MIN_PRICE = " select ci.carname, ci.cartype, ci.brand, ci.priceperday, ci.needlicence, cm.carnum, cm.isborrow from carinfo as ci join carmanagement as cm on ci.carname = cm.carname order by ci.priceperday ";
	
}
