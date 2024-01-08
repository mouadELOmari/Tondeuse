package com.mower.application.io;

import java.util.List;

public record FileContent(String firstLine, List<String> lines) {
}