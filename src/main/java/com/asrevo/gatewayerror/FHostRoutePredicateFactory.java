
package com.asrevo.gatewayerror;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author ashraf
 */
@Component
@Slf4j
public class FHostRoutePredicateFactory extends AbstractRoutePredicateFactory<FHostRoutePredicateFactory.Config> {

    private PathMatcher pathMatcher = new AntPathMatcher(".");

    public FHostRoutePredicateFactory() {
        super(Config.class);
    }

    public void setPathMatcher(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("patterns");
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.GATHER_LIST;
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                InetSocketAddress address = exchange.getRequest().getHeaders().getHost();
                if (address != null) {
                    String match = null;
                    String host = address.getHostName();
                    for (int i = 0; i < config.getPatterns().size(); i++) {
                        String pattern = config.getPatterns().get(i);
                        if (pathMatcher.match(pattern, host)) {
                            match = pattern;
                            break;
                        }
                    }

                    if (match != null) {
                        Map<String, String> variables = pathMatcher.extractUriTemplateVariables(match, host);
                        ServerWebExchangeUtils.putUriTemplateVariables(exchange, variables);
                        return true;
                    }

                }
                return false;
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("Hosts: %s", config.getPatterns());
            }
        };
    }

    @Validated
    public static class Config {

        private List<String> patterns = new ArrayList<>();

        public List<String> getPatterns() {
            return patterns;
        }

        public Config setPatterns(List<String> patterns) {
            this.patterns = patterns;
            return this;
        }

        @Override
        public String toString() {
            return new ToStringCreator(this).append("patterns", patterns).toString();
        }

    }

}
