package kz.karyakin.employeeservice.util;

import kz.karyakin.employeeservice.exception.DefaultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionUtils {

    public void throwDefaultException(MessageCode messageCode){
        throw new DefaultException(messageCode.getDefaultMessage(), messageCode.getErrorCode());
    }


}
