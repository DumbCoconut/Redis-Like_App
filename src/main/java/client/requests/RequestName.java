package client.requests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;

public class RequestName {
    public enum Cmd {
        QUIT, EXIT, HELP, ADD_SERVER, GET, SET, TYPE, DECR, DECRBY, INCR, INCRBY, DEL;
    }

    private HashMap<Cmd, String> cmds;

    private RequestName() {
        cmds = new HashMap<>();
        cmds.put(Cmd.QUIT, "quit");
        cmds.put(Cmd.EXIT, "exit");
        cmds.put(Cmd.HELP, "help");
        cmds.put(Cmd.ADD_SERVER, "add_server");
        cmds.put(Cmd.GET, "get");
        cmds.put(Cmd.SET, "set");
        cmds.put(Cmd.TYPE, "type");
        cmds.put(Cmd.DECR, "decr");
        cmds.put(Cmd.DECRBY, "decrby");
        cmds.put(Cmd.INCR, "incr");
        cmds.put(Cmd.INCRBY, "incrby");
        cmds.put(Cmd.DEL, "del");
    }

    private static RequestName ourInstance = null;

    public static RequestName getInstance() {
        if (ourInstance == null) {
            ourInstance = new RequestName();
        }
        return ourInstance;
    }

    public String getQuitCmd() {
        return cmds.get(Cmd.QUIT);
    }

    public String getExitCmd() {
        return cmds.get(Cmd.EXIT);
    }


    public String getHelpCmd() {
        return cmds.get(Cmd.HELP);
    }

    public String getAddServerCmd() {
        return cmds.get(Cmd.ADD_SERVER);
    }

    public String getGetCmd() {
        return cmds.get(Cmd.GET);
    }

    public String getSetCmd() {
        return cmds.get(Cmd.SET);
    }

    public String getTypeCmd() {
        return cmds.get(Cmd.TYPE);
    }

    public String getDecrCmd() {
        return cmds.get(Cmd.DECR);
    }

    public String getDecrByCmd() {
        return cmds.get(Cmd.DECRBY);
    }

    public String getIncrCmd() {
        return cmds.get(Cmd.INCR);
    }

    public String getIncrByCmd() {
        return cmds.get(Cmd.INCRBY);
    }

    public String getDelCmd() {
        return cmds.get(Cmd.DEL);
    }

    public String findClosestCmdMatch(String cmd) {
        HashMap<String, Integer> distances = new HashMap<>();
        for (Map.Entry<Cmd, String> e : cmds.entrySet()) {
            distances.put(e.getValue(), getLevenshteinDistance(cmd, e.getValue()));
        }
        Object[] entrySet = distances.entrySet().toArray();
        Arrays.sort(entrySet, (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));
        return ((Map.Entry<String, Integer>) entrySet[entrySet.length - 1]).getKey();
    }
}