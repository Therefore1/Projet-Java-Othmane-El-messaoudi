import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            Employe e1 = new EmployeFixe(
                    1,
                    "Ahmed",
                    "Ahmed@gmail.com",
                    "IT",
                    LocalDate.of(2020, 1, 10),
                    9000,
                    1000
            );

            Employe e2 = new EmployeHoraire(
                    2,
                    "Othmane",
                    "Othmane@gmail.com",
                    "INFO",
                    LocalDate.of(2023, 6, 5),
                    50,
                    190
            );


            System.out.println("Employé 1 (Fixe) :");
            System.out.println("Brut = " + e1.calculerSalaireBrut());
            System.out.println("Prime ancienneté = " + e1.calculerPrimeAnciennete());
            System.out.println("Net à payer = " + e1.calculerNetAPayer());

            System.out.println("\nEmployé 2 :");
            System.out.println("Brut = " + e2.calculerSalaireBrut());
            System.out.println("Prime ancienneté = " + e2.calculerPrimeAnciennete());
            System.out.println("Net à payer = " + e2.calculerNetAPayer());

        } catch (InvalidWorkDataException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
    }
}
