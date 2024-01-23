package thonguyenvan.interviewms.util.validation.editJob;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import thonguyenvan.interviewms.util.dto.jobs.EditJobDTO;

import java.time.LocalDate;
public class CheckEndDateValidator implements ConstraintValidator<CheckEndDate, EditJobDTO> {
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(CheckEndDate constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(EditJobDTO jobsDTO, ConstraintValidatorContext context) {

        if (jobsDTO == null) {
            return true;
        }
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(jobsDTO);

        LocalDate startDate = (LocalDate) beanWrapper.getPropertyValue(fields[0]);
        LocalDate endDate = (LocalDate) beanWrapper.getPropertyValue(fields[1]);

        if( startDate == null || endDate == null || endDate.isAfter(startDate)){
            return true;
        }else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(fields[fields.length-1]).addConstraintViolation();
            return false;
        }
    }
}