package lr2;

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Собака лает.");
    }

    public String getBreed() {
        return breed;
    }
}

class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает.");
    }

    public String getFoodType() {
        return foodType;
    }
}

class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Птица поет.");
    }

    public boolean isCanFly() {
        return canFly;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Рекс", 3, "Овчарка");
        System.out.println("Имя собаки: " + dog.getName());
        System.out.println("Возраст собаки: " + dog.getAge());
        System.out.println("Порода собаки: " + dog.getBreed());
        dog.makeSound();

        Cat cat = new Cat("Мурка", 2, "Сухой корм");
        System.out.println("Имя кошки: " + cat.getName());
        System.out.println("Возраст кошки: " + cat.getAge());
        System.out.println("Тип корма: " + cat.getFoodType());
        cat.makeSound();

        Bird bird = new Bird("Чиж", 1, true);
        System.out.println("Имя птицы: " + bird.getName());
        System.out.println("Возраст птицы: " + bird.getAge());
        System.out.println("Умеет летать: " + bird.isCanFly());
        bird.makeSound();
    }
}
