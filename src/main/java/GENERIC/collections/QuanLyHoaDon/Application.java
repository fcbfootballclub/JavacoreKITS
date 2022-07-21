package GENERIC.collections.QuanLyHoaDon;

import GENERIC.collections.QuanLyHoaDon.Orders.Order;
import GENERIC.collections.QuanLyHoaDon.Orders.OrderDetail;

import java.text.ParseException;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        //Tao khách hàng
        Customer customer1 = new Customer("CS01", "Henry1", "HN", "123");
        Customer customer2 = new Customer("CS02", "Henry2", "HN", "124");
        Customer customer3 = new Customer("CS03", "Henry3", "HN", "125");
        Customer customer4 = new Customer("CS04", "Henry4", "HN", "126");

        //Tạo nhà cung cấp
        Supplier supplier1 = new Supplier(1, "Supplier1", "Saigon", "121");
        Supplier supplier2 = new Supplier(2, "Supplier2", "Saigon", "122");
        Supplier supplier3 = new Supplier(3, "Supplier3", "Saigon", "123");
        Supplier supplier4 = new Supplier(4, "Supplier4", "Saigon", "124");

        //Tạo Order
        Order order1;
        Order order2;
        Order order3;
        try {
            order1 = new Order(1, "15-07-2022", "CS01");
            order2 = new Order(2, "14-07-2022", "CS02");
            order3 = new Order(3, "16-07-2022", "CS02");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Tạo order chi tiết
        OrderDetail orderDetail1 = new OrderDetail(1, 1, 1, 2, 20);
        OrderDetail orderDetail2 = new OrderDetail(1, 2, 3, 1, 40);
        OrderDetail orderDetail3 = new OrderDetail(2, 3, 2, 3, 30);
        OrderDetail orderDetail4 = new OrderDetail(3, 4, 1, 1, 20);
        OrderDetail orderDetail5 = new OrderDetail(3, 5, 2, 1, 30);


        //Bai 1. Tao TreeMap <Order, ArrayList>
        TreeMap<Order, ArrayList<OrderDetail>> OrderList = new TreeMap<>();

        //Key value cua order1
        List<OrderDetail> orderDetailList1 = new ArrayList<>();
        orderDetailList1.add(orderDetail1);
        orderDetailList1.add(orderDetail2);
        OrderList.put(order1, (ArrayList<OrderDetail>) orderDetailList1);

        //Key value cua order2
        List<OrderDetail> orderDetailList2 = new ArrayList<>();
        orderDetailList2.add(orderDetail3);
        OrderList.put(order2, (ArrayList<OrderDetail>) orderDetailList2);

        //Key value cua order3
        List<OrderDetail> orderDetailList3 = new ArrayList<>();
        orderDetailList3.add(orderDetail4);
        orderDetailList3.add(orderDetail5);
        OrderList.put(order3, (ArrayList<OrderDetail>) orderDetailList3);

        for(Order x : OrderList.keySet()){
            System.out.println(x.toString() + ". Value: " + OrderList.get(x));
        }

        //Tim kiem hoa don theo ma hoa don bằng 1
        Order searchOrder = new Order(); searchOrder.setIdOrder(1);
        System.out.println("Tìm kiếm order có id = 1: " + OrderList.containsKey(searchOrder));
        for(Order x : OrderList.keySet()){
            int sumMoney = 0;
            int sumItem = 0;
            if(x.getIdOrder() == 1){
                for(OrderDetail detail : OrderList.get(x)){
                    sumItem += detail.getAmount();
                    sumMoney += detail.getAmount() * detail.getPrice();
                }
                System.out.println("Hoa don 1 chi tiet mua: " + sumItem + ". Tong so tien:" + sumMoney);
                break;
            }
        }

        //Tìm hóa đơn có tổng số lượng lớn nhất và hóa đơn có total value lớn nhất
        int maxQuantityOrder = 0;
        Map<Integer, Integer> maxQuantityOrderID = new HashMap<>(); //lưu những order có quantity lớn nhất vào đây
        int maxTotalOrderValue = 0;
        Map<Integer, Integer> maxTotalValueOrderID = new HashMap<>(); //Lưu những order có giá trị lớn nhất vào đây

        int sumQuantity;
        int totalValue;
        for(Order x : OrderList.keySet()){
            sumQuantity = 0;
            totalValue = 0;
            for(OrderDetail a : OrderList.get(x)){
                sumQuantity += a.getAmount();
                totalValue += a.getAmount() * a.getPrice();
            }

            //check số lượng item nhiều nhất và gắn vào dãy
            if(sumQuantity == maxQuantityOrder){
                maxQuantityOrderID.put(x.getIdOrder(), maxQuantityOrder);
            } else if (sumQuantity > maxQuantityOrder) {
                maxQuantityOrder = sumQuantity;
                maxQuantityOrderID.clear();
                maxQuantityOrderID.put(x.getIdOrder(), maxQuantityOrder);
            }

            //check value to nhất vào gắn vào list
            if(totalValue == maxTotalOrderValue){
                maxTotalValueOrderID.put(x.getIdOrder(), maxTotalOrderValue);
            } else if (totalValue > maxTotalOrderValue) {
                maxTotalValueOrderID.clear();
                maxTotalOrderValue = totalValue;
                maxTotalValueOrderID.put(x.getIdOrder(), maxTotalOrderValue);
            }

        }

        //in ra kết quả
        System.out.println("Những order có số lượng item lớn nhất là: ");
        for(Integer x : maxQuantityOrderID.keySet()){
            System.out.println("Order ID: " + x + ". Quantity: " + maxQuantityOrderID.get(x));
        }

        System.out.println("Những order có số lượng total Value lớn nhất là: ");
        for(Integer x : maxTotalValueOrderID.keySet()){
            System.out.println("Order ID: " + x + ". Quantity: " + maxTotalValueOrderID.get(x));
        }

        //Bài 1.2:    --------------------------------------------------------------------------
        //Tạo ít nhất là 02 khách hàng
        TreeMap <Customer, ArrayList<Order>> customers_order_List = new TreeMap<>();

        ArrayList<Order> listCS01 = new ArrayList<>(); //tạo array list chứa thông tin order của từng khách hàng
        listCS01.add(order1);
        ArrayList<Order> listCS02 = new ArrayList<>(); //tạo array list chứa thông tin order của từng khách hàng
        listCS02.add(order2);
        listCS02.add(order3);

        customers_order_List.put(customer1, listCS01); //add khách hàng vào orders List của họ vào list
        customers_order_List.put(customer2, listCS02);

        //- Thực hành tìm kiếm danh sách hoá đơn theo mã khách hàng
        Customer searchCustomer = new Customer();
        searchCustomer.setId("CS02");
        System.out.println("Tìm kiếm danh sách hóa đơn theo mã khách hàng: ");
        for(Customer x : customers_order_List.keySet()){
            if(x.equals(searchCustomer)) {
                customers_order_List.get(x).stream().toList().forEach(System.out::println);
                break;
            }
        }

        //- Xác định khách hàng có nhiều hóa đơn nhất và in ra màn hình: Khách hàng và Số lượng hóa đơn tương ứng.
        HashMap<Customer, Integer> KhachHang_soLuongHoaDon = new HashMap<>();
        int count_order = 0;
        int max_order = 0;
        for(Customer x : customers_order_List.keySet()){
            count_order = customers_order_List.get(x).size();
            if(count_order == max_order) {
                KhachHang_soLuongHoaDon.put(x, max_order);
            } else if(count_order > max_order) {
                KhachHang_soLuongHoaDon.clear();
                max_order = count_order;
                KhachHang_soLuongHoaDon.put(x, max_order);
            }
        }
        for(Customer x : KhachHang_soLuongHoaDon.keySet()){
            System.out.println(x + ". Mua số lượng hóa đơn nhiều nhất là: " + KhachHang_soLuongHoaDon.get(x));
        }


        //Bài2 : Hãy xây dựng và chèn đơn nhập hàng vào các cấu trúc dữ liệu sau:---------------------------------------
        //- Tạo ít nhất 02 khách hàng, mỗi khách hàng ít nhất 02 Order, mỗi Order ít nhất là 02 OrderDetail
        HashMap <Customer, TreeMap <Order, ArrayList<OrderDetail>> > customerAndOrderDetailList = new HashMap<>();

        TreeMap <Order, ArrayList<OrderDetail>> order_orderDetail_CS01 = new TreeMap<>();
        order_orderDetail_CS01.put(order1, (ArrayList<OrderDetail>) orderDetailList1);

        TreeMap <Order, ArrayList<OrderDetail>> order_orderDetail_CS02 = new TreeMap<>();
        order_orderDetail_CS02.put(order2, (ArrayList<OrderDetail>) orderDetailList2);
        order_orderDetail_CS02.put(order3, (ArrayList<OrderDetail>) orderDetailList3);

        //put value <order and detail order> to map
        customerAndOrderDetailList.put(customer1, order_orderDetail_CS01);
        customerAndOrderDetailList.put(customer2, order_orderDetail_CS02);

        //Tìm kiếm hóa đơn theo mã khách hàng
        System.out.println("Tìm kiếm khách hàng có mã là CS02 và in ra hóa đơn của người này: ");
        Customer customerSearch2 = new Customer();
        customerSearch2.setId("CS02");
        for(Customer x : customerAndOrderDetailList.keySet()){
            if(x.equals(customerSearch2)){
                for(Order y : customerAndOrderDetailList.get(x).keySet()){
                    System.out.println("Hóa đơn: " + y);
                }
            }
        }

        //Xác định khách hàng có tổng tiền mua hàng lớn nhất
        totalValue = 0; //tổng số tiền mua của mỗi khách hàng
        maxTotalOrderValue = 0; //tổng số tiền nhiều nhất mà một khách hàng mua (cộng tất cả các order của khách hàng)
        HashMap<Customer, Integer> bestCustomers = new HashMap<>();
        for(Customer x : customerAndOrderDetailList.keySet()){
            totalValue = 0;
            for(Order y : customerAndOrderDetailList.get(x).keySet()){
                for(OrderDetail z : customerAndOrderDetailList.get(x).get(y)){
                    totalValue += z.getPrice() * z.getAmount();
                }
            }
            if(totalValue == maxTotalOrderValue){
                bestCustomers.put(x, maxTotalOrderValue);
            } else if(totalValue > maxTotalOrderValue){
                bestCustomers.clear();
                maxTotalOrderValue = totalValue;
                bestCustomers.put(x, maxTotalOrderValue);
            }
        }
        System.out.println("Những khách hàng có tổng tiền doanh thu lớn nhất là: ");
        for(Customer x : bestCustomers.keySet()){
            System.out.println("Customer: " + x + ". Max value: " + maxTotalOrderValue);
        }

    }
}
