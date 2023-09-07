import java.util.Optional;

/**
 * @Author hongyi
 * @Date 2023/4/11 10:57
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }


    public static void main(String[] args) {
//赋值试卷附属信息
        for (BusExamPaperDto u : dtoList) {
            Optional.ofNullable(sessionMap.get(u.getPaperId)).ifPresent(sessionList ->
                            sessionList.stream()
                                    .filter(t -> t.getExamStatus() == ExamStatusEnum.RUNNING.getCode())
                                    .findFirst()
                                    .ifPresentorELse(t -> {
                                                u.setExamStatus((byte) ExamStatusEnum.RUNNING.getCode());
                                                u.setBusExanSessionDTO(t);
                                            },
                                            () -> u.setExamstatus((byte) ExamStatusEnum.END.getCode())),
                    () -> u.setExamStatus((byte) ExamStatusEnum.NO_START.getCode()));
            return new PageImpl<>(dtoList, pageList.getPageable(), pageList.getTotalELements());
        }
    }
}