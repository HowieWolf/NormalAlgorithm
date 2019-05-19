package problem;

/**
 * 输入一个字符串命令，请解析出他代表的真正字符串
 * <p>
 * 例如
 * 3[ab] -> ababab
 * 2[bc3[ol]r] -> bcolololrbcolololr
 */
public class CommandToString {

    public String parse(String command) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            char c = command.charAt(index);
            if (isFlag(c)) {
                Task task = findTask(command, index);
                result.append(doTask(task));
                index += task.len;
            } else {
                result.append(c);
                index++;
            }
        }
        return result.toString();
    }

    private Task findTask(String command, int start) {
        boolean hasStart = false;
        int index = start;
        int count = 0;
        while (!hasStart || count != 0) {
            char c = command.charAt(index);
            if ('[' == c) {
                count++;
                hasStart = true;
            } else if (']' == c) {
                count--;
            }
            index++;
        }
        return new Task(command.substring(start, index));
    }

    private String doTask(Task task) {
        String content = parse(task.content);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < task.repeat; i++) {
            result.append(content);
        }
        return result.toString();
    }

    private boolean isFlag(char c) {
        return c >= '0' && c <= '9';
    }

    private class Task {
        int repeat;
        String content;
        int len;

        Task(String taskStr) {
            int left = taskStr.indexOf('[');
            repeat = Integer.parseInt(taskStr.substring(0, left));
            len = taskStr.length();
            content = taskStr.substring(left + 1, len - 1);
        }

        @Override
        public String toString() {
            return "repeat=" + repeat + ",len=" + len + ",content=" + content;
        }
    }

    public static void main(String[] args) {
        CommandToString test = new CommandToString();
        String result = test.parse("2[bc3[ol]r]");
        System.out.println(result);
    }
}
