package com.pky.smartselling.configuration.filter;

import com.google.firebase.auth.FirebaseToken;
import com.pky.smartselling.configuration.security.FirebaseAuthenticationToken;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.domain.employee.EmployeeActiveStatus;
import com.pky.smartselling.service.EmployeeService;
import com.pky.smartselling.service.FirebaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.pky.smartselling.configuration.constant.HttpRequestAttributes.AUTHORIZATION_FIREBASE;

@Slf4j
public class FirebaseFilter extends OncePerRequestFilter {

    final FirebaseService firebaseService;
    final EmployeeService employeeService;

    public FirebaseFilter(FirebaseService firebaseService, EmployeeService employeeService) {
        this.firebaseService = firebaseService;
        this.employeeService = employeeService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String xAuth = request.getHeader(AUTHORIZATION_FIREBASE);
        if (StringUtils.isBlank(xAuth)) {
            filterChain.doFilter(request, response);
            return;
        } else {

            try {
                FirebaseToken firebaseToken = this.firebaseService.getToken(xAuth);
                Employee employee = employeeService.findByEmailByStatus(firebaseToken.getEmail(), EmployeeActiveStatus.ACTIVE)
                        .orElse(employeeService.updateMatchFirebaseUid(firebaseToken));
                SecurityContextHolder.getContext().setAuthentication(new FirebaseAuthenticationToken(employee));
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                log.info("Firebase not found token {}", xAuth);
            }
        }
    }
}
