package pages;

import org.junit.jupiter.api.Test;

    public class PaginationValue {
        private int first;
        private int last;
        private int total;

        public static PaginationValue parse(String str) {
            String[] tokens = str.split(" ");
            PaginationValue value = new PaginationValue();

            value.first = Integer.parseInt(tokens[0]);
            value.last = Integer.parseInt(tokens[2]);
            value.total = Integer.parseInt(tokens[4]);
            return value;
        }

        private PaginationValue() {}

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


