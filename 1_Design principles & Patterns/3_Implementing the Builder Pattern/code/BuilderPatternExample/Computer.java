package BuilderPatternExample;

public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
 
    }

    public static class Builder {
        private final String cpu;
        private final String ram;
        private String storage;
       
        public Builder(String cpu, String ram,String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage=storage;
        }
        public Computer build() {
            return new Computer(this);
        }
    }

    
    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + (storage != null ? storage : "Not Available"));
       
    }
}
