package client.requests.dataStructures.set;


import client.requests.RequestWithKey;
import client.requests.exceptions.InvalidNbArgException;
import client.requests.exceptions.NoTokensException;

import java.util.ArrayList;

public class RequestSPop extends RequestWithKey {
    /**
     * The minimum number of arguments required to properly construct the request.
     */
    private final int minNbArgs = 1;

    /**
     * Constructor.
     *
     * @param tokens The different words of the request, e.g {"spop", "key"}.
     * @throws InvalidNbArgException When not enough arguments are provided to the request.
     * @throws NoTokensException     When no tokens are provided to the request.
     */
    public RequestSPop(ArrayList<String> tokens) throws InvalidNbArgException, NoTokensException {
        super(tokens);
        setNbArgs(minNbArgs);
        parse();
    }

    /**
     * Parse the tokens and retrieve the key.
     * @throws InvalidNbArgException When not enough arguments are provided to the request.
     */
    public void parse() throws InvalidNbArgException {
        if (tokens.size() != nbExpectedTokens()) {
            throw new InvalidNbArgException(tokens.size() - 1, minNbArgs);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "spop(\"" + key + "\")";
    }
}
