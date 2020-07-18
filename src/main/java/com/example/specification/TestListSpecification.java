package com.example.specification;

import com.example.entity.Test;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class TestListSpecification extends BaseSpecification<Test, TestListRequest> {

    @Override
    public Specification<Test> getFilter(TestListRequest request) {
        return (root, query, cb) -> {
            query.distinct(true); //Important because of the join in the addressAttribute specifications
            return Specification.where(
                    Specification.where(testIdContains(request.getSearch()))
//                            .or(lastNameContains(request.getSearch()))
//                            .or(emailContains(request.getSearch()))
            ).toPredicate(root, query, cb);
        };

    }

    private Specification<Test> testIdContains(String testId) {
        if(testId !=null){
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            if(pattern.matcher(testId).matches()){
                return userAttributeContains("id", testId);
            }
        }
        return userAttributeContains("id", null);
    }
//
//    private Specification<Test> lastNameContains(String lastName) {
//        return userAttributeContains("lastName", lastName);
//    }
//
//    private Specification<Test> emailContains(String email) {
//        return userAttributeContains("email", email);
//    }

    private Specification<Test> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
            else{
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                if(pattern.matcher(value).matches()){
                    return cb.equal(root.get(attribute),value);
                }
                return cb.like(
                        cb.lower(root.get(attribute)),
                        containsLowerCase(String.valueOf(value))
                );
            }
        };
    }

}
