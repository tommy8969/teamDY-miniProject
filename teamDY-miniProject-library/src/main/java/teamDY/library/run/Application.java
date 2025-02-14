package teamDY.library.run;

import teamDY.library.aggregate.Book;
import teamDY.library.aggregate.BookStatus;
import teamDY.library.aggregate.Category;
import teamDY.library.service.BookService;

import java.util.Scanner;

public class Application {

    private static final BookService bs = new BookService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== 도서 관리 시스템 =====");
            System.out.println("1. 도서 목록 조회");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 대출");
            System.out.println("4. 도서 반납");
            System.out.println("5. 대출 기간 연장");
            System.out.println("6. 도서 추가");
            System.out.println("7. 도서 삭제");
            System.out.println("9. 종료");
            System.out.print("메뉴를 선택해주세요: ");

            int input = sc.nextInt();

            switch (input) {
                case 1: bs.findAllBooks(); break;
                case 2: bs.searchBook(); break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: bs.addBook(bookInfo()); break;
//                case 7: bs.deleteBook(); break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴를 다시 선택하세요.");
                    break;
            }

        }

    }

    private static Book bookInfo() {
        Scanner sc = new Scanner(System.in);
        Book bookInfo = null;
        System.out.println("===== 등록할 책 정보 입력 =====");
        System.out.print("제목 :");
        String title = sc.nextLine();
        System.out.print("저자: ");
        String author = sc.nextLine();
        System.out.print("카테고리(소설, 사회, 과학, 예술, 어린이): ");
        Category ctg = null;
        String category = sc.nextLine();
        switch (category) {
            case "소설":
                ctg = Category.FICTION;
                break;
            case "사회":
                ctg = Category.SOCIETY;
                break;
            case "과학":
                ctg = Category.SCIENCE;
                break;
            case "예술":
                ctg = Category.ART;
                break;
            case "어린이":
                ctg = Category.CHILDREN;
                break;
            default:
                System.out.println("카테고리를 정확히 입력하세요.");
                break;
        }

        bookInfo = new Book(title, author, ctg);

        return bookInfo;
    }


}
