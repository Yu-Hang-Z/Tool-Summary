package zyh.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by zhangyuhang
 * @Classname PageUtil
 * @Description TODO
 * @Date 2022/3/31 17:41
 */
public class PageUtil {

    /**
     * 手动分页类
     * @param datas
     * @param pageSize
     * @param pageNo
     * @param <T>
     * @return
     */
    public static <T> List<T> getPageSizeDataForRelations(List<T> datas, int pageSize, int pageNo){
        int startNum = (pageNo-1)* pageSize+1 ;                     //起始截取数据位置
        if(startNum > datas.size()){
            return null;
        }
        List<T> res = new ArrayList<>();
        int rum = datas.size() - startNum;
        if(rum < 0){
            return null;
        }
        if(rum == 0){                                               //说明正好是最后一个了
            int index = datas.size() -1;
            res.add(datas.get(index));
            return res;
        }
        if(rum / pageSize >= 1){                                    //剩下的数据还够1页，返回整页的数据
            for(int i=startNum;i<startNum + pageSize;i++){          //截取从startNum开始的数据
                res.add(datas.get(i-1));
            }
            return res;
        }else if((rum / pageSize == 0) && rum > 0){                 //不够一页，直接返回剩下数据
            for(int j = startNum ;j<=datas.size();j++){
                res.add(datas.get(j-1));
            }
            return res;
        }else{
            return null;
        }
    }
}
