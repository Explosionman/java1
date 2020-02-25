package lesson5;

public class Main {
    public static void main(String[] args) {
        Employees[] employeesArray = new Employees[5];
        employeesArray[0] = new Employees("Дэвид Бэкхмэм", "полузащитник", "db@mail.com",
                "81234567852", 10_000_000, 44);
        employeesArray[1] = new Employees("Артём Дзюба", "нападающий", "artd@mail.com",
                "81245695154", 5_000_000, 31);
        employeesArray[2] = new Employees("Василий Иванов", "судья", "vasiv@mail.com",
                "89568453256", 500_000, 35);
        employeesArray[3] = new Employees("Юрий Сёмин", "тренер", "uriysemin@mail.com",
                "81234567852", 3_000_000, 72);
        employeesArray[4] = new Employees("Алексей Миранчук", "полузащитник", "almir@mail.com",
                "81234567852", 4_000_000, 24);

        System.out.println("Информация о сотрудниках старше 40: ");
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40) {
                employeesArray[i].getInfo();
                System.out.println();
            }
        }
    }
}
