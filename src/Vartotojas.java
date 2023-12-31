import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vartotojas implements Serializable {
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static int vartototojuKiekis = 0;
    private int id;
    private String vardas;
    private String slaptazodis;
    private String email;
    private Lytis lytis;
    final private LocalDateTime regData;
    private LocalDate gimimoData;
    private boolean isActive = true;

    //for imports
    //geriau daryti ji private, ir load date from that static loadFromCSV method
    public Vartotojas(int id, String vardas, String slaptazodis, String email, Lytis lytis, LocalDateTime regData, LocalDate gimimoData, boolean isActive, int vartototojuKiekis) {
//      negalima del regData private
//      this(vardas, slaptazodis, email, lytis, gimimoData);
        this.id = id;
        this.vardas = vardas;
        this.slaptazodis = slaptazodis;
        this.email = email;
        this.lytis = lytis;
        this.regData = regData;
        this.gimimoData = gimimoData;
        this.isActive = isActive;
        Vartotojas.vartototojuKiekis = vartototojuKiekis;
    }

    //<editor-fold desc="only csv visible">
    public Vartotojas(String vardas, String slaptazodis, String email, Lytis lytis, LocalDate gimimoData) {
        this.id = vartototojuKiekis++;
        this.vardas = vardas;
        this.slaptazodis = slaptazodis;
        this.email = email;
        this.lytis = lytis;
        this.gimimoData = gimimoData;
        this.regData = LocalDateTime.now();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
//    public Vartotojas(int id) {
//        this.id = id;
//        this.regData = LocalDateTime.now();
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Vartotojas that = (Vartotojas) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    public LocalDateTime getRegData() {
        return regData;
    }


    public LocalDate getGimimoData() {
        return gimimoData;
    }

    public void setGimimoData(LocalDate gimimoData) {
        this.gimimoData = gimimoData;
    }

    public Vartotojas() {
        this.id = vartototojuKiekis;
        vartototojuKiekis++;
        regData = LocalDateTime.now();
    }

    //<editor-fold desc="Setters/Getters/Etc">

    public static int getVartototojuKiekis() {
        return vartototojuKiekis;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lytis getLytis() {
        return lytis;
    }

    public void setLytis(Lytis lytis) {
        this.lytis = lytis;
    }

    @Override
    public String toString() {
        return String.format("[%s] Id: %d | Vardas: %s | Slaptazodis: %s | Email: %s | Lytis: %s | Gimimo data: %s | Reg data: %s",
                isActive ? "🟢" : "🔴", id, vardas, slaptazodis, email, lytis, gimimoData, regData.format(dtf));
    }

    //</editor-fold>
    //</editor-fold>
    public String toCSVline() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%b,%d",
                id, vardas, slaptazodis, email, lytis, regData, gimimoData, isActive, vartototojuKiekis);
    }


    public static Vartotojas fromCSV(String text) {
        //TODO implement
        text.split(",");
        return null;
    }

}
