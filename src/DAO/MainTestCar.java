package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DTO.CarInfoDTO;
import DTO.ReservationDTO;
import DTO.ReservationInfoDTO;
import DTO.ReservationPersonInfoDTO;
import DTO.SelectDTO;

public class MainTestCar {

	public static void main(String[] args) {
		CarDAO dao = new CarDAO();
		ReservationInfoDTO infoDTO = new ReservationInfoDTO();
		ReservationPersonInfoDTO personInfoDTO = new ReservationPersonInfoDTO();
		int state = dao.getState();

		try (Connection conn = DBCarConnectionManager.getConnection(); Scanner sc = new Scanner(System.in)) {
			while (true) {
				Menu();
				int menuchoice = sc.nextInt();
				if (menuchoice == 1) {
					// 차량으로 예약하기
					ReservationByCarMenu();
					int ReservationByCarMenuchoice = sc.nextInt();
					if (ReservationByCarMenuchoice == 1) {
						System.out.println("== 브랜드 필터 ==");
						System.out.println("1. 기아  2. 현대  3. 테슬라");
						String brand = null;
						int brandchoice = sc.nextInt();
						if (brandchoice == 1) {
							brand = "기아";
						} else if (brandchoice == 2) {
							brand = "현대";
						} else if (brandchoice == 3) {
							brand = "테슬라";
						}
						List<SelectDTO> list = dao.viewBrandType(brand);
						for (SelectDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					} else if (ReservationByCarMenuchoice == 2) {
						System.out.println("== 차종 필터 ==");
						System.out.println("1. 준중형  2. 중형  3. 대형");
						String cartype = null;
						int cartypechoice = sc.nextInt();
						if (cartypechoice == 1) {
							cartype = "준중형";
						} else if (cartypechoice == 2) {
							cartype = "중형";
						} else if (cartypechoice == 3) {
							cartype = "소형";
						}
						List<SelectDTO> list = dao.viewCarType(cartype);
						for (SelectDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					} else if (ReservationByCarMenuchoice == 3) {
						System.out.println("== 유종 필터 ==");
						System.out.println("1. 전기  2. 수소  3. 가스  4. 디젤  5. 가솔린");
						String puel = null;
						int puelchoice = sc.nextInt();
						if (puelchoice == 1) {
							puel = "전기";
						} else if (puelchoice == 2) {
							puel = "수소";
						} else if (puelchoice == 3) {
							puel = "가스";
						} else if (puelchoice == 4) {
							puel = "디젤";
						} else if (puelchoice == 5) {
							puel = "가솔린";
						}
						List<CarInfoDTO> list = dao.selecPuel(puel);
						for (CarInfoDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					} else if (ReservationByCarMenuchoice == 4) {
						System.out.println("== 가격순 필터 ==");
						System.out.println("1. 낮은 가격부터  2. 높은 가격부터");
						int orderchoice = sc.nextInt();
						if (orderchoice == 1) {
							List<SelectDTO> list = dao.orderAscPriceType();
							for (SelectDTO selectDTO : list) {
								System.out.println(selectDTO);
							}
						} else if (orderchoice == 2) {
							List<SelectDTO> list = dao.orderDescPriceType();
							for (SelectDTO selectDTO : list) {
								System.out.println(selectDTO);
							}
						}
					} else if (ReservationByCarMenuchoice == 5) {
						System.out.println("== 면허 필터 ==");
						System.out.println("1. 1종  2. 2종");
						String needLicence = null;
						int needLicencechoice = sc.nextInt();
						if (needLicencechoice == 1) {
							needLicence = "1종";
						} else if (needLicencechoice == 2) {
							needLicence = "2종";
						}
						List<SelectDTO> list = dao.viewneedLicenceType(needLicence);
						for (SelectDTO selectDTO : list) {
							System.out.println(selectDTO);
						}
					}
				} else if (menuchoice == 2) {
					// 날짜로 예약하기
					// 추가
				} else if (menuchoice == 3) {
					// 예약조회 및 변경하기
					ViewandUpdateMenu();
					int viewUpdatechoice = sc.nextInt();
					if (viewUpdatechoice == 1) {
						System.out.println("== 이름으로 조회하기 ==");
						System.out.print("예약자 성함 : ");
						String name = sc.next();
						List<ReservationDTO> list = dao.reservationNameSelec(name);
						for (ReservationDTO reservationDTO : list) {
							System.out.println(reservationDTO);
						}
					} else if (viewUpdatechoice == 2) {
						System.out.println("== 예약번호로 조회하기 ==");
						System.out.print("예약번호 : ");
						int id = sc.nextInt();
						ReservationDTO dto = dao.reservationNumSelec(id);
					} else if (viewUpdatechoice == 3) {
						System.out.println("== 예약 변경하기 ==");
						System.out.println("1. 대여일 변경  2. 반납일 변경 3. 차량 변경");
						int updatechoice = sc.nextInt();
						if (updatechoice == 1) {
							System.out.println("== 대여일 변경 ==");
							System.out.println(" 예약 번호를 입력 해주세요");
							int id = sc.nextInt();
							sc.nextLine();
							String rent = sc.nextLine();
							Date date = Date.valueOf(rent);
							dao.changeRent(date, id);
							System.out.println("변경이 완료 되었습니다.");
							ReservationDTO dto = dao.reservationNumSelec(id);
							System.out.println(dto.toString());

						} else if (updatechoice == 2) {
							System.out.println("== 반납일 변경 ==");
							System.out.println(" 예약 번호를 입력 해주세요");
							int id = sc.nextInt();
							System.out.println("변경하실 날자를 입력해주세여");
							sc.nextLine();
							String rent = sc.nextLine();
							Date date = Date.valueOf(rent);
							dao.changeReturn(date, id);
							System.out.println("변경이 완료 되었습니다.");
							ReservationDTO dto = dao.reservationNumSelec(id);

						} else if (updatechoice == 3) {
							System.out.println("== 차량 변경 ==");
							System.out.println("변경하실 예약번호를 입력해주세여");
							int id = sc.nextInt();
							System.out.println("변경할 차번호를 입력해주세여");
							sc.nextLine();
							String carname = sc.nextLine();
							dao.changeCat(carname, id);
							System.out.println("변경이 완료 되었습니다.");
							ReservationDTO dto = dao.reservationNumSelec(id);
							System.out.println(dto.toString());
						}

					} else if (viewUpdatechoice == 4) {
						System.out.println("== 예약 취소하기 == ");
						// 보류
					}

				} else if (menuchoice == 4) {
					// 예약
					System.out.println("예약학기");
					sc.nextLine();
					System.out.println("이름");
					String name = sc.nextLine();

					System.out.println("면허번호");
					String licenseNum = sc.nextLine();
					;

					System.out.println("면허종류");
					String licenseGreade = sc.nextLine();

					System.out.println("전화번호");
					String phoneNum = sc.nextLine();
					dao.insertPerson(name, licenseNum, licenseGreade, phoneNum);
					System.out.println("입금방식을 선택해줘세요");
					System.out.println("0. 무통장, 1. 현장결제");
					if (state == 1) {
						// 번호가 없다
						int pay = sc.nextInt();
						System.out.println("state1");
						if (pay == 0) {
							dao.truePerson(phoneNum, pay);
						} else if (pay == 1) {
							dao.truePerson(phoneNum, pay);
						} else {
							System.err.println("다시입력");
						}
					} else if (state == 2) {
						// 번호가 있다
						System.out.println("state2");
						int pay = sc.nextInt();
						if (pay == 0) {
							dao.falsePerson(pay);
						} else if (pay == 1) {
							dao.falsePerson(pay);
						} else {
							System.out.println("다시");
						}

					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void Menu() {
		System.out.println("1. 차량으로 예약하기");
		System.out.println("2. 날짜로 예약하기");
		System.out.println("3. 예약조회 및 변경하기");
	}

	private static void ReservationByCarMenu() {
		System.out.println("== 차량으로 예약하기 ==");
		System.out.println("1. 브랜드 필터");
		System.out.println("2. 차종 필터");
		System.out.println("3. 유종필터");
		System.out.println("4. 가격순 필터");
		System.out.println("5. 면허 필터");
	}

	private static void ViewandUpdateMenu() {
		System.out.println("== 예약조회 및 변경하기 ==");
		System.out.println("1. 이름으로 조회하기");
		System.out.println("2. 예약번호로 조회하기");
		System.out.println("3. 예약 변경하기");
		System.out.println("4. 예약 취소하기");
	}
}
