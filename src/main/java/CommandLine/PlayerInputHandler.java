package CommandLine;

public class PlayerInputHandler implements InputInterface {

    final String player_request_msg = "Type your nickname:";
    final String player_err_msg = "This nickname is not valid. Try another one:";
    final String player_pattern = "\\w+";

    final String pie_rule_request_msg = "If you want to apply the pie rule, type '1'; otherwise type '0'.";
    final String pie_rule_err_msg = "Not valid. Please type '0' or '1':";
    final String pie_rule_pattern = "[0-1]";

    final String coordinate_request_msg = "Insert valid coordinates or type 'res' to resign:";
    final String coordinate_err_msg = "Not valid. Please insert again (a-o and 1-15, e.g. f3) or type 'res' to resign:";
    final String coordinate_pattern = "[a-o][1-9]|[a-o]1[0-5]|res";

    public String getPlayer_request_msg() {
        return player_request_msg;
    }

    public String getPlayer_err_msg() {
        return player_err_msg;
    }

    public String getPlayer_pattern() {
        return player_pattern;
    }

    public String getCoordinate_request_msg() {
        return coordinate_request_msg;
    }

    public String getCoordinate_err_msg() {
        return coordinate_err_msg;
    }

    public String getCoordinate_pattern() {
        return coordinate_pattern;
    }
}
