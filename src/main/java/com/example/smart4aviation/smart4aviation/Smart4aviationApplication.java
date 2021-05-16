package com.example.smart4aviation.smart4aviation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Smart4aviationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Smart4aviationApplication.class, args);
	}

}

/*
* - można trochę uporządkować pakiety: masz pakiet flightmodel w którym jest tylko jedna klasa więc ją można przerzucić do pakietu flight żeby było spójnie z cargo i baggage
- jeśli jest klasa abstrakcyjna dla Cargo i Baggage to wrzuć tą klasę abstrakcyjną i wszystkie które ją rozszerzają do jednego pakietu, bo tak to na pierwszy rzut oka wygląda jakby ta klasa abstrakcyjna była tylko rozszerzana przez klasę Cargo. Ogólnie strukturę pakietów można zmienić też na model, service, controller - dla takich małych projektów taki podział wydaje mi się bardziej sensowny, przy większych projektach gdzie jest dużo klas operujących na jakimś obiekcie (np. Cargo) robi się wtedy taki pakiet z typem obiektu i wewnątrz niego jeszcze dzieli się na model, service, controller
- adnotacja @DiscriminatorValue służy do rozróżnienia klas dziedziczących po klasie bazowej, które są w jednej tabeli. Jeśli ma taką samą wartość to przeglądając bazę nie będzie wiadomo które obiekty to Cargo, a które Baggage. Możesz w discriminatorValue podać po prostu nazwy obiektów.
- cała klasa FlightWithCargoAndBaggage to jest takie dublowanie tego co Hibernate mógłby zrobić sam, bo to w zasadzie jest tabela łącząca Flight z Cargo i Baggage. Te relacje oneToMany z listami Cargo i Baggage przerzuć sobie do klasy Flight i wyjdzie na to samo, a będzie można usunąć cały ten pakiet z FlightWithCargoAndBaggage.
- patrząc na treść zadań to brakuje endpointu do wyciagania informacji po dacie i numerze lotu. W interfejsach repository to można łączyć przez np. findByDateAndFlightCode (podstaw sobie swoje nazwy zmiennych)
- widzę że w drugim zadaniu zwracasz informacje jako String. To jest dość niewygodne jeśli potem ktoś chciałby tych informacji użyć (np. do zbudowania frontendu), bo trzeba by parsować ten tekst i wyciągać z niego pojedyncze słowa. Zamiast tego do zwracania takich informacji pisze się nowe klasy DTO - Data Transfer Object, które mają dokładnie takie pola jakie potrzebujesz zwrócić, czyli w przypadku tego zadania 2 byłoby to np. AirportFlightsDetailsDTO
{
	flightsDeparting: 123,
	flightsArriving: 123,
	arrivingBaggageTotalPieces: 1234,
	departingBaggageTotalPieces: 1234
}
Taka klasa to zwykła klasa Javy, nie jest zapisywana w bazie, bo służy tylko do przeniesienia danych. Podobną możesz sobie zbudować do zwrócenia tych informacji z zadania 1.
- jeśli chodzi o gita to staraj się w opisach commitów dawać krótkie info co zostało dodane/zmienione/usunięte. To jest bardziej czytelne bo łatwiej potem znaleźć gdzie i kiedy były zrobione jakieś zmiany, no i też pokaże że wiesz o co chodzi w gicie.
- sprawdź sobie co Ci generuje adnotacja lombokowa @Data, bo na pewno @Getter, @Setter, @NoArgsConstructor, chyba @ToString nie będą potrzebne, bo to wszystko się zawiera w @Data
- w klasie Flight masz inną strategię generowania id niż w pozostałych. To też mieć dobrze takie samo w całym projekcie*/
