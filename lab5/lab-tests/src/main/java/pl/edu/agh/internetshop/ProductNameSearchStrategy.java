package pl.edu.agh.internetshop;

public class ProductNameSearchStrategy implements SearchStrategy {
        private String productName;
        public ProductNameSearchStrategy(String productName) {
            this.productName = productName;
        }

        public boolean filter(Order order) {
            for(Product product: order.getProducts()) {
                if(product.getName().equals(productName)) {
                    return true;
                }
            }
            return false;
        }
}
