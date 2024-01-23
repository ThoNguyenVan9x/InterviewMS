package thonguyenvan.interviewms.util.validation.editJob;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import thonguyenvan.interviewms.util.dto.jobs.EditJobDTO;

import java.math.BigDecimal;
public class CheckMaxSalaryValidator implements ConstraintValidator<CheckMaxSalary, EditJobDTO> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(CheckMaxSalary constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(EditJobDTO jobsDTO, ConstraintValidatorContext context) {

        if (jobsDTO == null) {
            return true;
        }
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(jobsDTO);

        BigDecimal minSalary = (BigDecimal) beanWrapper.getPropertyValue(fields[0]);
        BigDecimal maxSalary = (BigDecimal) beanWrapper.getPropertyValue(fields[1]);

        if(minSalary == null || maxSalary == null || maxSalary.compareTo(minSalary)>0){
            return true;
        }else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(fields[fields.length-1]).addConstraintViolation();
            return false;
        }
    }
}
