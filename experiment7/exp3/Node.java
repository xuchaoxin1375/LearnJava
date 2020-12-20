package experiment7.exp3;

import java.util.Arrays;

/*�����Ƚ�һ����Node��
��Ա������double pageRank(�ڵ��pagerankֵ)��String name���ڵ�������String[] adjacentNodeNames���ڵ�������ڽӽڵ����飩*/
class Node {
    double PageRank;//�ڵ��pagerankֵ
    double oldPageRank;
    String name;//�ڵ���
    String[] adjacentNodeNames;//�ڵ�������ڽӽڵ�����
    double tmpCount = 0;
    double outValue;

    public double getOutValue() {
        if (adjacentNodeNames.length >= 1)
            return outValue = PageRank / adjacentNodeNames.length;
        else
            return 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();//ҪnewŶ
        String str = "";
        if (adjacentNodeNames.length > 0) {
            for (int i = 0; i < adjacentNodeNames.length; i++) {
                stringBuffer.append(adjacentNodeNames[i] + "\t");
            }
        }
        //С��stringBufferʼ��Ϊnull
        if (stringBuffer != null) {
            str = stringBuffer.toString();
        }
        return name + ":" + PageRank + "\t" + str/*+ "\n"*/;
    }

    public String getName() {
        return name;
    }

    public double addTmpCount(double plusNum) {
        return this.tmpCount += plusNum;
    }

    public void setPageRank(/*double pageRank*/) {
        oldPageRank = PageRank;
        PageRank = tmpCount;
        tmpCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdjacentNodeNames(String[] adjacentNodeNames) {
        this.adjacentNodeNames = adjacentNodeNames;
    }

    public double getPageRank() {
        return PageRank;
    }

    public String[] getAdjacentNodeNames() {
        return adjacentNodeNames;
    }

    public Node(double pageRank, String name, String[] adjacentNodeNames) {
        PageRank = pageRank;
        this.name = name;
        this.adjacentNodeNames = adjacentNodeNames;
        tmpCount = 0;
    }

    public double getDelta() {
        return Math.abs(this.PageRank - this.oldPageRank);
    }

}
