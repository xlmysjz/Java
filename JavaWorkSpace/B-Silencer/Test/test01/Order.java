package test01;
class Order implements Comparable<Order> {  
    String key;  
    int count;  
      
    public Order(String key, int count) {  
        this.key = key;  
        this.count = count;  
    }  
  
    @Override  
    public int compareTo(Order o) {  
        return (count > o.count) ? 1 : count == o.count ? 0 : -1;  
    }  
  
}  