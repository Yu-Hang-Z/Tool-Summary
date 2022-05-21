package zyh.example.demo.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyh.example.demo.mbg.model.TSensitiveWordType;
import zyh.example.demo.mbg.model.TSensitiveWordTypeExample;

public interface TSensitiveWordTypeMapper {
    long countByExample(TSensitiveWordTypeExample example);

    int deleteByExample(TSensitiveWordTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSensitiveWordType record);

    int insertSelective(TSensitiveWordType record);

    List<TSensitiveWordType> selectByExample(TSensitiveWordTypeExample example);

    TSensitiveWordType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSensitiveWordType record, @Param("example") TSensitiveWordTypeExample example);

    int updateByExample(@Param("record") TSensitiveWordType record, @Param("example") TSensitiveWordTypeExample example);

    int updateByPrimaryKeySelective(TSensitiveWordType record);

    int updateByPrimaryKey(TSensitiveWordType record);
}