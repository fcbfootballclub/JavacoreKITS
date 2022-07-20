package BTVNStreamAPI.Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Customer cus01 = new Customer("BBC1", "Hanoi");
        Customer cus02 = new Customer("ABC2", "Haiphong");
        Customer cus03 = new Customer("ZBC3", "Haiphong");
        Customer cus04 = new Customer("DBC4", "Hanoi");
        Customer cus05 = new Customer("YBC5", "Saigon");
        Customer cus06 = new Customer("UBC6", "Saigon");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(cus01);
        customerList.add(cus02);
        customerList.add(cus03);
        customerList.add(cus04);
        customerList.add(cus05);
        customerList.add(cus06);

        Transaction transaction1 = new Transaction(cus01, 2021, "San pham 1", 1);
        Transaction transaction2 = new Transaction(cus01, 2022, "San pham 2", 5);
        Transaction transaction3 = new Transaction(cus02, 2020, "San pham 3", 15);
        Transaction transaction4 = new Transaction(cus03, 2022, "San pham 4", 25);
        Transaction transaction5 = new Transaction(cus04, 2021, "San pham 1", 35);
        Transaction transaction6 = new Transaction(cus05, 2021, "San pham 3", 50);
        Transaction transaction7 = new Transaction(cus06, 2020, "San pham 2", 12);
        Transaction transaction8 = new Transaction(cus01, 2021, "San pham 1", 10);
        Transaction transaction9 = new Transaction(cus04, 2021, "San pham 4", 1);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
        transactionList.add(transaction6);
        transactionList.add(transaction7);
        transactionList.add(transaction8);
        transactionList.add(transaction9);

        System.out.println("2.1 Giao dịch thực hiện trong năm 2021 và sắp xếp chúng theo số lượng tăng dần");
        transactionList.stream().filter(s -> s.getYear() == 2021).sorted((s1, s2) -> s1.getAmount() - s2.getAmount()).forEach(System.out::println);

        System.out.println("2.2. In ra danh sách các địa chỉ của Customer (trùng thì loại)");
        customerList.stream().map(Customer::getAddress).distinct().forEach(System.out::println);

        System.out.println("2.2.1. In ra danh sách Customer (những khách hàng trùng địa chỉ thì chỉ in đc 1 người)");
        customerList.stream().distinct().forEach(System.out::println);

        System.out.println("2.3. Xác định tất cả các khách hàng chung một địa chỉ nào đó, sort by name của khách hàng và in ra");
        customerList.stream().filter(s -> s.getAddress().equals("Hanoi")).sorted().forEach(System.out::println); //sort mặc định là theo tên

        System.out.println("2.4. Sắp xếp tất cả khách hành theo tên và in ra.");
        customerList.stream().sorted().forEach(System.out::println);

        System.out.println("Kiểm tra xem có khách hàng ở địa chỉ nào đó hay không (y/n)?");
        boolean check = customerList.stream().anyMatch(s -> s.getAddress().equals("Hanoi1"));
        System.out.println(check);

        System.out.println("2.6. Xác định số lượng (amount) lớn nhất xuất hiện trong các giao dịch và in ra");
        transactionList.stream().map(Transaction::getAmount).forEach(System.out::println);
        System.out.println("In ra số lượng lớn nhất:");
        int maxAmount = transactionList.stream().max((s1, s2) -> s1.getAmount() - s2.getAmount()).get().getAmount();
        System.out.println(maxAmount);

        System.out.println("2.6.2. In ra giao dịch có số lượng lớn nhất");
        List<Transaction> demo = transactionList.stream().filter(s -> s.getAmount() == maxAmount).toList();
        demo.forEach(System.out::println);

        System.out.println("2.7. Tính và in ra tổng số lượng trong các giao dịch của các khách hàng ở một địa chỉ nào đó");
        int count = transactionList.stream().filter(s -> s.getTrader().getAddress().equals("Hanoi")).mapToInt(Transaction::getAmount).sum();
        System.out.println(count);

        System.out.println("2.8. Xác định và in ra giao dịch có số lượng nhỏ nhất");
        transactionList.stream().min((s1, s2) -> s1.getAmount() - s2.getAmount()).stream().toList().forEach(System.out::println);
    }
}
