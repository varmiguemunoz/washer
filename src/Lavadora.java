import java.util.Timer;
import java.util.TimerTask;

class Lavadora {
    private int pesoRopa;
    private int nivelAgua;
    private String ciclo;

    public Lavadora(int pesoRopa, int nivelAgua, String ciclo) {
        this.pesoRopa = pesoRopa;
        this.nivelAgua = nivelAgua;
        this.ciclo = ciclo;
    }

    public boolean validarRestricciones() {
        if (ciclo.equalsIgnoreCase("Alto")) {
            return pesoRopa == 18 && nivelAgua == 25;
        } else if (ciclo.equalsIgnoreCase("Medio")) {
            return (pesoRopa >= 10 && pesoRopa <= 17) && (nivelAgua >= 15 && nivelAgua <= 24);
        } else if (ciclo.equalsIgnoreCase("Bajo")) {
            return pesoRopa < 10 && nivelAgua == 12;
        }
        return false;
    }
    public void iniciarCiclo() {
        if (!validarRestricciones()) {
            System.out.println("No se cumplen las restricciones para iniciar el ciclo.");
            return;
        }
        System.out.println("Iniciando ciclo " + ciclo);
        Timer timer = new Timer();
        int tiempoCiclo = 0;

        if (ciclo.equalsIgnoreCase("Alto")) {
            tiempoCiclo = 4;
        } else if (ciclo.equalsIgnoreCase("Medio")) {
            tiempoCiclo = 3;
        } else if (ciclo.equalsIgnoreCase("Bajo")) {
            tiempoCiclo = 2;
        }

        int finalTiempoCiclo = tiempoCiclo;

        timer.scheduleAtFixedRate(new TimerTask() {
            int segundos = 0;

            @Override
            public void run() {
                if (segundos < finalTiempoCiclo) {
                    switch (segundos) {
                        case 0:
                            System.out.println("Llenando...");
                            break;
                        case 1:
                            System.out.println("Estregando...");
                            break;
                        case 2:
                            System.out.println("Enjuagando...");
                            break;
                        case 3:
                            System.out.println("Secando...");
                            break;
                        case 4:
                            System.out.println("Finalizando...");
                            break;
                    }
                    segundos++;
                } else {
                    System.out.println("Ciclo " + ciclo + " completado.");
                    timer.cancel();
                }
            }
        }, 1000, 1000);
    }
}


