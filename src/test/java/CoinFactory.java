
public class CoinFactory {
    public static Coin getCoinInstance(Coins coin){
        return switch (coin) {
            case USD -> new USD();
            case ILS -> new ILS();
            case EUR -> new EUR();
        };
    }
}