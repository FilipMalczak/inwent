# Data model

```
                                             Name
                                               ▲ 1
                                               │
                                               │
                                               │ is_named
                                               │
          1                                    │1..n
Namespace───────────────────────────────────► Tag                                  Location
                   contains            0..n   ▲                                        │
                                              │1                                       │1..n
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │is_of                                   │
                                              │                                        │refers_to
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │                                        │
                                              │0..n                                    │ 1
                    originates_from           │               is_about                 ▼
Origin ◄────────────────────────────────────Hit ───────────────────────────────────► Content
        1                               0..n    0..n                              1
```