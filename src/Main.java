public class Main {
    public static void main(String[] args) {
        AmericanSocket socket = new SimpleAmericanSocket();
        Radio radio = new Radio();
        EuropeanSocket eurosSocket = new SocketAdapter(socket);
        radio.listenMusic(eurosSocket);
    }
}

interface EuropeanSocket {
    void getPower();
}

class SocketAdapter implements EuropeanSocket{
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower(){
        americanSocket.getPower();
    }
}

interface AmericanSocket {
    void getPower();
}

class SimpleAmericanSocket implements AmericanSocket{
    @Override
    public void getPower() {
        System.out.println("get 110 volt");
    }
}

class Radio{
    public void listenMusic(EuropeanSocket europeanSocket){
        europeanSocket.getPower();
    }
}