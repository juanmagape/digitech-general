public class Personaje {
    private String nombre;
    private int skillPoints;
    private int cantMana;
    private int danoCuerpoaCuerpo;
    private int danoMagia;
    private int vida;

    public Personaje(String nombre, int skillPoints, int cantMana, int danoCuerpoaCuerpo, int danoMagia, int vida) {
        this.nombre = nombre;
        this.skillPoints = skillPoints;
        this.cantMana = cantMana;
        this.danoCuerpoaCuerpo = danoCuerpoaCuerpo;
        this.danoMagia = danoMagia;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getCantMana() {
        return cantMana;
    }

    public void setCantMana(int cantMana) {
        this.cantMana = cantMana;
    }

    public int getDanoCuerpoaCuerpo() {
        return danoCuerpoaCuerpo;
    }

    public void setDanoCuerpoaCuerpo(int danoCuerpoaCuerpo) {
        this.danoCuerpoaCuerpo = danoCuerpoaCuerpo;
    }

    public int getDanoMagia() {
        return danoMagia;
    }

    public void setDanoMagia(int danoMagia) {
        this.danoMagia = danoMagia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void mostrarEstadisticasJug() {
        System.out.println("=======================================================");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Vida: " + this.getVida());
        System.out.println("Cantidad mana: " + this.getCantMana());
        System.out.println("Daño cuerpo a cuerpo: " + this.getDanoCuerpoaCuerpo());
        System.out.println("Ataque magico: " + this.getDanoMagia());
        System.out.println("=======================================================");
    }
}
