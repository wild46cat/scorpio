package com.xueyou.scorpio.shrio;


import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "shrioFilter", urlPatterns = "/*")
public class ShrioFilter extends DelegatingFilterProxy {
    public ShrioFilter() {
        this.setTargetFilterLifecycle(true);
    }
}
