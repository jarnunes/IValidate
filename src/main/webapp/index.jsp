<%response.sendRedirect(request.getContextPath() + "com/ivalidate/web/home.jsf" + (request.getQueryString() != null ? "?" + request.getQueryString() : ""));%>