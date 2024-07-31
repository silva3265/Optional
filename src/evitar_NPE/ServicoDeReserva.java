package evitar_NPE;

import java.util.*;

public class ServicoDeReserva {

    private final Set<Reserva> reservas = new HashSet<>();

    public Collection<Reserva> getReservas() {
        return Collections.unmodifiableSet(reservas);
    }

    public void adicionar(Reserva reserva) { /* Passando um objeto do tipo reserva */
        boolean reservaAdicionada = reservas.add(reserva); /* e adicionamos a uma coleção */

        if (!reservaAdicionada) { /* se a reserva NÃO for adcionada (negação), lançe uma exceção */
            throw new RuntimeException(
                    String.format("Reserva %s já existe", reserva.getCodigo()));
        }
    }

    public Reserva buscar(String codigo) {
        Reserva reservaEncontrada = null;

        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                reservaEncontrada = reserva;
                break;
            }
        }

        return reservaEncontrada;
    }

}