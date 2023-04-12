package test;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class BookScrabbleHandler implements ClientHandler {
    PrintWriter out;
    Scanner in;

    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        out = new PrintWriter(outToClient);
        in = new Scanner(inFromclient);
        String request = in.nextLine();
        RequestParams requestParams = getRequestParams(request);
        boolean result = getRequestResult(requestParams);
        out.println(result);
        out.flush();
    }

    private static boolean getRequestResult(RequestParams requestParams) {
        DictionaryManager dm = DictionaryManager.get();
        boolean result = false;
        if (Objects.equals(requestParams.queryType(), "Q"))
            result = dm.query(requestParams.queryArgs());
        else if (Objects.equals(requestParams.queryType(), "C"))
            result = dm.challenge(requestParams.queryArgs());
        return result;
    }

    private static RequestParams getRequestParams(String request) {
        String[] args = request.split(",");
        String queryType = args[0];
        String[] queryArgs = Arrays.copyOfRange(args, 1, args.length);
        return new RequestParams(queryType, queryArgs);
    }

    private record RequestParams(String queryType, String[] queryArgs) {
    }

    @Override
    public void close() {
        in.close();
        out.close();
    }
}
