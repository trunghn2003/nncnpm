package nncnpm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAO29 {
    private Connection connection;

    public StatisticsDAO29(Connection connection) {
        this.connection = connection;
    }

   public List<CustomerStatistics29> getListCustomer() {
        List<CustomerStatistics29> customerStats = new ArrayList<>();
        String sql = "SELECT c.Id, c.CustomerName, c.PhoneNumber, " +
                     "SUM(i.TotalOutstanding) AS TotalOutstanding, " +
                     "SUM(CASE WHEN DATEDIFF(day, i.PaymentDate, GETDATE()) > 30 THEN i.TotalOutstanding ELSE 0 END) AS TotalOverdueDebt " +
                     "FROM tblCustomer29 c " +
                     "LEFT JOIN tblInvoiceCustomer29 i ON c.Id = i.Id " +
                     "GROUP BY c.Id, c.CustomerName, c.PhoneNumber " +
                     "ORDER BY SUM(i.TotalOutstanding) DESC";  // Sắp xếp theo tổng dư nợ giảm dần
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CustomerStatistics29 stats = new CustomerStatistics29(
                    rs.getInt("Id"),
                    rs.getString("CustomerName"),
                    "",  // Địa chỉ không được yêu cầu
                    rs.getString("PhoneNumber"),
                    rs.getFloat("TotalOutstanding"),
                    rs.getFloat("TotalOverdueDebt")
                );
                customerStats.add(stats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerStats;
    }
//   public List<Partner_Product29> getListProductsForContract(int contractId) {
//        List<Partner_Product29> products = new ArrayList<>();
//        String sql = """
//                     SELECT pr.Id, pr.ProductName, pr.UnitPrice, cpp.Quantity
//                                          FROM tblContract29 c
//                                          JOIN tblContract_Partner_Product29 cpp ON c.Id = cpp.ContractId
//                                          JOIN tblPartner_Product29 pp ON cpp.Partner_ProductId = pp.Id
//                                          JOIN tblProduct29 pr ON pp.ProductId = pr.Id
//                                          WHERE c.Id = ?
//                     """;
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, contractId);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Partner_Product29 product = new Partner_Product29(
//                    rs.getInt("ProductId"),
//                    rs.getString("ProductName"),
//                    rs.getInt("Quantity"),
//                    rs.getFloat("UnitPrice")
//                );
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }

   public List<CustomerContractStatistics29> getListContract(Customer29 customer) {
        List<CustomerContractStatistics29> contractStats = new ArrayList<>();
        // Update the SQL query to only focus on necessary fields
        String sql = "SELECT c.Id AS ContractId, c.SigningDate, c.TotalPrice, c.TotalQuantity, " +
                     "COALESCE(SUM(ic.TotalOutstanding), 0) AS TotalOutstanding, " +  // Ensure nulls are handled
                     "COALESCE(SUM(CASE WHEN DATEDIFF(day, ic.PaymentDate, GETDATE()) > 30 THEN ic.TotalOutstanding ELSE 0 END), 0) AS TotalOverdue " +
                     "FROM tblContract29 c " +
                     "JOIN tblInvoiceCustomer29 ic ON c.Id = ic.ContractId " +
                     "WHERE ic.CustomerId = ? " +
                     "GROUP BY c.Id, c.SigningDate, c.TotalPrice, c.TotalQuantity, ic.TotalOutstanding";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customer.getCustomerId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CustomerContractStatistics29 contract = new CustomerContractStatistics29(
                    rs.getInt("ContractId"),
                    "Unknown",  // Assuming contract name isn't fetched; use "Unknown" or modify SQL to include it
                    rs.getFloat("TotalPrice"),
                    rs.getInt("TotalQuantity"),
                    rs.getString("SigningDate"),
                    0,  // Assuming no loan period data is available, set it to 0 or fetch if available
                    rs.getFloat("TotalOutstanding"),
                    rs.getFloat("TotalOverdue")
                );
                contractStats.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractStats;
    }
  public ContractDetail_Customer29 getDetailContract(int contractId) {
        ContractDetail_Customer29 contractDetail = null;
        List<ProductDetail> products = new ArrayList<>();

        String sql = """
                     SELECT c.Id, c.Name, c.TotalPrice, c.TotalQuantity, c.SigningDate, c.LoanPeriod,
                                                              cu.CustomerName AS CustomerName, p.PartnerName AS PartnerName,
                                                              pr.Id as ProductId, pr.ProductName, pr.UnitPrice, cpp.Quantity
                                                              FROM tblContract29 c
                                                              LEFT JOIN tblCustomer29 cu ON c.CustomerId = cu.Id
                                                              LEFT JOIN tblContract_Partner_Product29 cpp ON c.Id = cpp.ContractId
                                                              LEFT JOIN tblPartner_Product29 ppp ON cpp.Partner_ProductId = ppp.Id
                                                              LEFT JOIN tblProduct29 pr ON ppp.ProductId = pr.Id
                                                              LEFT JOIN tblPartner29 p ON ppp.PartnerId = p.Id
                                                              WHERE c.Id = ?;
                     """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contractId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (contractDetail == null) {
                    contractDetail = new ContractDetail_Customer29(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getFloat("TotalPrice"),
                        rs.getInt("TotalQuantity"),
                        rs.getString("SigningDate"),
                        rs.getInt("LoanPeriod"),
                        rs.getString("CustomerName"),
                        rs.getString("PartnerName"),
                        products // Passing the list to store product details
                    );
                }
                products.add(new ProductDetail(
                    rs.getInt("ProductId"),
                    rs.getString("ProductName"),
                    rs.getFloat("UnitPrice"),
                    rs.getInt("Quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetail;
    }
  

}
