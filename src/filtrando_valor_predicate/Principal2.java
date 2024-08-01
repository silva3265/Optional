package filtrando_valor_predicate;

public class Principal2 {

	public static void main(String[] args) {
		var servicoDeReserva = new ServicoDeReserva();
		var servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
		var voo = new Voo("G31333", "UDI", "GRU");

		servicoDeReserva.adicionar(new Reserva("28A888", voo, "João da Silva"));
		servicoDeReserva.adicionar(new Reserva("28B111", voo, "Maria da Silva"));
		servicoDeReserva.adicionar(new Reserva("74F877", voo, "Sebastião Coelho"));

		servicoDeBagagem.contratar("28A888", 1);

		Reserva reserva = servicoDeReserva.buscar("28A888").filter(r -> r.getQuantidadeBagagens() > 0)
				.orElseThrow(RuntimeException::new); /* filter - ele vai retornar um Optional reserva, vai determinar se determinada condição é verdadeira, caso contrario ele retorna um Optional Vazio*/

		System.out.println(reserva);

//        Reserva reserva = servicoDeReserva.buscar("28A888")
//                .orElseThrow(RuntimeException::new);
//
//        if (reserva.getQuantidadeBagagens() > 0) {
//            System.out.println(reserva);
//        }
	}

}
