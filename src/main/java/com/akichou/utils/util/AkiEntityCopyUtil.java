package com.akichou.utils.util;

import com.akichou.utils.exception.EntityCopyException;
import com.akichou.utils.log.AkiLogger;
import com.akichou.utils.log.AkiLoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AkiEntityCopyUtil {

    private static final AkiLogger akiLogger =
            AkiLoggerFactory.getAkiLogger(AkiEntityCopyUtil.class) ;

    private AkiEntityCopyUtil() {}

    public static <T> T copyEntity(Object copiedTarget, Class<T> resultClazz) {

        T result ;

        try {

            result = resultClazz.getDeclaredConstructor().newInstance() ;

            BeanUtils.copyProperties(copiedTarget, result) ;
        } catch (Exception e) {

            akiLogger.error("Error occurred while copying entity from {} to {}",
                             copiedTarget.getClass().getName(),
                             resultClazz.getName(),
                             e) ;

            throw new EntityCopyException("Error occurred while copying entity", e) ;
        }

        return result ;
    }

    public static <T, V> List<V> copyEntityList(List<T> copiedTargetList, Class<V> resultClazz) {

        return copiedTargetList.stream()
                .map(o -> copyEntity(o, resultClazz))
                .toList() ;
    }
}
