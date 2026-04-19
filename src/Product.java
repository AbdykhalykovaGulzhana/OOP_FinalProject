class Product extends Item {
    private String category;

    public Product(String name, int quantity, double price, String category) {
        super(name, quantity, price);

        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void display() {
        System.out.println(getName() + " | " + getQuantity() + " | " + getPrice() + " | " + category);
    }
}
