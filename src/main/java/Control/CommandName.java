package Control;

/**
 * enum комманд
 */
public enum CommandName {
    ADD("add"),
    SHOW("show"),
    CLEAR("clear"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    FILTER_GREATER_THEN_NUMBER_OF_PARTICIPANTS("filter_greater_than_number_of_participants"),
    HELP("help"),
    HEAD("head"),
    INFO("info"),
    REMOVE_BY_ID("remove_by_id"),
    REMOVE_HEAD("remove_head"),
    ADD_IF_MAX("add_if_max"),
    AVERAGE_OF_ALBUMS_COUNT("average_of_albums_count"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name"),
    SAVE("save"),
    UPDATE("update"),
    ERROR("error");

    private String command;

    CommandName(String command){
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
