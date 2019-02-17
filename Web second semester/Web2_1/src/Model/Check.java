package Model;

public class Check {
    /**
     * @param=closed uses to inform Admin that check was close
     * @param=sum represents sum of service
     * @param=NoId id of Number
     * @param=ReqId id of Request
    */
    private boolean closed;
    private int sum;
    private int NoId;
    private int ReqId;

    public Check(boolean closed, int sum, int NoId, int ReqId){
        this.closed = closed;
        this.sum = sum;
        this.NoId = NoId;
        this.ReqId = ReqId;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getNoId() {
        return NoId;
    }

    public void setNoId(int noId) {
        NoId = noId;
    }

    public int getReqId() {
        return ReqId;
    }

    public void setReqId(int reqId) {
        ReqId = reqId;
    }
}
