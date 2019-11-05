package pages;

import org.junit.jupiter.api.Test;

    public class PaginationValue {
        private int first;
        private int last;
        private int total;

        public PaginationValue(String str) {
            first = parseString(str, 0);
            last = parseString(str, 2);
            total = parseString(str, 4);
        }

        private int parseString(String s, int number) {
            return Integer
                    .parseInt(s.split(" ")[number]);
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }

        public int getTotal() {
            return total;
        }
    }


