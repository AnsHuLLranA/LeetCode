class Solution {
    public int maxDiff(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int a = Integer.parseInt(ChooseMaxNum(arr));
        int b = Integer.parseInt(ChooseMinNum(arr));
        return a - b;
    }

    private String ChooseMinNum(char[] c) {
        int len = c.length;
        char act = ' ';
        StringBuilder sb = new StringBuilder();
        char rep = ' ';

        if (c[0] == '1') {
            for (int i = 1; i < len; i++) {
                if (c[i] != '0') {
                    if (c[i] == '1') {
                        continue;
                    } else {
                        act = c[i];
                        rep = '0';
                        break;
                    }
                }
            }
        } else {
            act = c[0];
            rep = '1';
        }

        for (int i = 0; i < len; i++) {
            if (c[i] == act) {
                sb.append(rep);
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }

    private String ChooseMaxNum(char[] c) {
        int len = c.length;
        char rep = ' ';
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (c[i] != '9') {
                rep = c[i];
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (c[i] == rep) {
                sb.append('9');
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}
