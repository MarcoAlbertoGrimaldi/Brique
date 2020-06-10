package CommandLine;

public class PlayerInputHandler implements InputInterface {

    String player_request_msg = "Type you nickname:";
    String player_err_msg = "Unexpected error";
    String player_pattern = "\\w";

    String pie_rule_request_msg = "If you want to apply the pie rule, type '1'; otherwise type '0'.";
    String pie_rule_err_msg = "Please type '0' or '1'.";
    String pie_rule_pattern = "[0-1]";

    String coordinate_request_msg = "Insert coordinates or type 'res' to resign:";
    String coordinate_err_msg = "Not valid, please insert again (a-o and 1-15, e.g. f3)";
    String coordinate_pattern = "[a-o][1-9]|[a-o]1[0-5]|res";

    public String getPlayer_request_msg() {
        return player_request_msg;
    }

    public String getPlayer_err_msg() {
        return player_err_msg;
    }

    public String getPlayer_pattern() {
        return player_pattern;
    }

    public String getPie_rule_request_msg() {
        return pie_rule_request_msg;
    }

    public String getPie_rule_err_msg() {
        return pie_rule_err_msg;
    }

    public String getPie_rule_pattern() {
        return pie_rule_pattern;
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
