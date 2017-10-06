package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.PunsterBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("punsterBSBDJMapper")
public interface PunsterBSBDJMapper extends JpaRepository<PunsterBSBDJ, Integer> {

    public PunsterBSBDJ getPunsterBSBDJByMark(String mark);

}
