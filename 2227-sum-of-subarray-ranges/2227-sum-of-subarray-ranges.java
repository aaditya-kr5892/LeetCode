class Solution {
    public long subArrayRanges(int[] nums) {
        mini obj1 = new mini();
        maxi obj2 = new maxi();
        long large = obj2.sumSubarrayMaxs(nums);
        long small = obj1.sumSubarrayMins(nums);
        return large - small;
    }
}

class mini {
    public long sumSubarrayMins(int[] arr) {
        long result = 0;
        int[] pre = pree(arr);
        int[] nex = next(arr);

        for (int i = 0; i < arr.length; i++) {
            long left = i - pre[i];
            long right = nex[i] - i;
            long contribution = left * right * arr[i];

            result += contribution;
        }
        return result;
    }

    int[] pree(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pre = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            pre[i] = st.empty() ? -1 : st.peek();
            st.add(i);
        }
        return pre;
    }

    int[] next(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nex = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            nex[i] = st.empty() ? arr.length : st.peek();
            st.add(i);
        }
        return nex;
    }
}

class maxi {
    public long sumSubarrayMaxs(int[] arr) {
        long result = 0;
        int[] pre = pree(arr);
        int[] nex = next(arr);

        for (int i = 0; i < arr.length; i++) {
            long left = i - pre[i];
            long right = nex[i] - i;
            long contribution = left * right * arr[i];

            result += contribution;
        }
        return result;
    }

    int[] pree(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pre = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            pre[i] = st.empty() ? -1 : st.peek();
            st.add(i);
        }
        return pre;
    }

    int[] next(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nex = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            nex[i] = st.empty() ? arr.length : st.peek();
            st.add(i);
        }
        return nex;
    }
}
