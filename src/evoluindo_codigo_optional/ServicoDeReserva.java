package evoluindo_codigo_optional;

import java.util.*;

public class ServicoDeReserva {

    private final Set<Reserva> reservas = new HashSet<>();

    public Collection<Reserva> getReservas() {
        return Collections.unmodifiableSet(reservas);
    }

    public void adicionar(Reserva reserva) {
        boolean reservaAdicionada = reservas.add(reserva);

        if (!reservaAdicionada) {
            throw new RuntimeException(
                    String.format("Reserva %s já existe", reserva.getCodigo()));
        }
    }

    public Optional<Reserva> buscar(String codigo) { /* vai retornar um Optional de <Reserva>*/
//        Reserva reservaEncontrada = null;

        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                return Optional.of(reserva); /* of - ele vai criar um Optional de um valor que não é Nullo */
//                reservaEncontrada = reserva;
//                break;
            }
        }

        return Optional.empty(); /* Vai retornar um Optional vazio */
//        return Optional.ofNullable(reservaEncontrada); /* ofNullable - ele vai receber o valor que vamos receber dentro do Container 'caixinha '*/
    }

}